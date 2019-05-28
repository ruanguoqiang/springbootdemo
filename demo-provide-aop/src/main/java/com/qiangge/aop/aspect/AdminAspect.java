package com.qiangge.aop.aspect;

import com.qiangge.Vo.Result;
import com.qiangge.anonation.validator.Validator;
import com.qiangge.anonation.validator.annotation.ValidateParam;
import com.qiangge.aop.service.PermissionService;
import com.qiangge.exception.ErrorType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class AdminAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PermissionService permissionService;

    // TODO 这是注解AOP功能
    @Pointcut(value = "@annotation(com.qiangge.aop.annotation.HttpCall)")
    public void annotationPointCut() {
    }

    @Pointcut("execution(public * com.qiangge.anonation.service..*.*(..))")
    public void PointCut(){}

    @Before("PointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("------------------------------------------------------------");
        logger.info("------------------------------------------------------------");
    }


    @Around("PointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        try {
            Method currentMethod = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
            Annotation[][] an = currentMethod.getParameterAnnotations();
            ParamInfo paramInfo=null;
            for (int j=0;j<an.length;j++){
                paramInfo=new ParamInfo(parameterNames[j]);
                ValidateParam validateParam=this.getParameterAnnotation(ValidateParam.class,an[j]);
                if (validateParam!=null){
                    paramInfo.setValidators(validateParam.value());
                }
                validateValue(args[j],paramInfo.getName(),paramInfo.getValidators());
            }
        } catch (NoSuchMethodException e) {
            Object retObj = e.getCause();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(ErrorType.SYSTEM_ERROR,null);
        }
     /*   String methodName = signature.getMethod().getName();
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session =request.getSession();
        System.out.println((Integer)session.getAttribute("id"));
        if(!validate(methodName,(Integer)session.getAttribute("id"))){
            return Result.fail(ErrorType.SYSTEM_NO_AUTH);
        }*/
        try {
            logger.info("权限校验成功");
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            return null;
        }
    }

    @AfterThrowing(pointcut = "PointCut()", throwing = "e")
    public void handleThrowing(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        //开始打log
        System.out.println("异常:" + e.getMessage());
        System.out.println("异常所在类：" + className);
        System.out.println("异常所在方法：" + methodName);
        System.out.println("异常中的参数：");
        System.out.println(methodName);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i].toString());
        }
    }


    private boolean validate(String methodName,Integer id){
        // TODO 实现校验功能
        if(permissionService.checkIsLogin(id)) {
            return true;
        }
        return false;
    }

    protected static class ParamInfo {

        private String paramName;

        private String name;

        private Validator[] validators;

        public ParamInfo() {
            super();
        }

        public ParamInfo(String paramName) {
            super();
            this.paramName = paramName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Validator[] getValidators() {
            return validators;
        }

        public void setValidators(Validator[] validators) {
            this.validators = validators;
        }
    }

    private void validateValue(Object value, String cName, Validator[] validators)
            throws Exception {
        for (int i = 0; i < validators.length; i++) {
            Validator validator = Validator.getValidator(validators[i]);
            if (validator != null) {
                if (value != null && value.toString().trim() != "") {
                    validator.validate(cName, value.toString());
                }
                else {
                    if (Validator.NOT_BLANK.equals(validator)) {
                        validator.validate(cName, null);
                    }
                }
            }
            else {
                logger.error("验证器[" + validators[i] + "],在Validator.java文件中没有定义，请检查！");
            }
        }
    }

    @Nullable
    public <A extends Annotation> A getParameterAnnotation(Class<A> annotationType, Annotation[] anns) {
        Annotation[] var3 = anns;
        int var4 = anns.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Annotation ann = var3[var5];
            if (annotationType.isInstance(ann)) {
                return (A) ann;
            }
        }
        return null;
    }
}


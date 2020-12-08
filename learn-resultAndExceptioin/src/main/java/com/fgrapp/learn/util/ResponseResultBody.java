package com.fgrapp.learn.util;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * ResponseResultBody
 *
 * @author fan guang rui
 * @date 2020年12月08日 15:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {

}

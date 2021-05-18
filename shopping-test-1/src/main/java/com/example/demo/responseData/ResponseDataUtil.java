package com.example.demo.responseData;


public class ResponseDataUtil {
   /**
    * 带实体的统一返回
    *
    * @param data 实体
    * @param <T>  实体类型
    * @return
    */
   public static <T> ResponseData<T> buildSuccess(T data) {
       return new ResponseData<T>(ResultEnums.SUCCESS, data);
   }

   public static  <T> ResponseData<T> buildSuccess() {
       return new ResponseData<T>(ResultEnums.SUCCESS);
   }

   public static <T> ResponseData<T> buildSuccess(String msg) {
       return new ResponseData<T>(ResultEnums.SUCCESS.getCode(), msg);
   }

   public static <T> ResponseData<T> buildSuccess(String code, String msg) {
       return new ResponseData<T>(code, msg);
   }

   public static <T> ResponseData<T> buildSuccess(String code, String msg, T data) {
       return new ResponseData<T>(code, msg, data);
   }

   public static <T> ResponseData<T> buildSuccess(ResultEnums resultEnums) {
       return new ResponseData<T>(resultEnums);
   }

   public static <T> ResponseData<T> buildError(T data) {
       return new ResponseData<T>(ResultEnums.ERROR, data);
   }

   public static <T> ResponseData<T> buildError() {
       return new ResponseData<T>(ResultEnums.ERROR);
   }

   public static <T> ResponseData<T> buildError(String msg) {
       return new ResponseData<T>(ResultEnums.ERROR.getCode(), msg);
   }

   public static <T> ResponseData<T> buildError(String code, String msg) {
       return new ResponseData<T>(code, msg);
   }

   public static <T> ResponseData<T> buildError(String code, String msg, T data) {
       return new ResponseData<T>(code, msg, data);
   }

   public static <T> ResponseData<T> buildError(ResultEnums resultEnums) {
       return new ResponseData<T>(resultEnums);
   }
}
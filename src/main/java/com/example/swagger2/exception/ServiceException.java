package com.example.swagger2.exception;

public class ServiceException extends RuntimeException{
    private String code ;
    private String message;

    public ServiceException(String code, String message){
        this.code = code;
        this.message = message;
    }

    public ServiceException(Throwable e){
        super(e);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ServiceEnum s = ServiceEnum.ERROR;
        switch (s){
            case ERROR:
                System.out.println("这是个错误");
                break;
            case FORBIDDEN:
                System.out.println("被禁止");
                break;
            case NOT_FOUND:
                System.out.println("未找到");
                break;
            default:
                System.out.println("搞错了吧");
        }

        String str = "3";
        switch (str){
            case "1":
                System.out.println("11111");
                break;
            case "2":
                System.out.println("22222");
                break;
            default:
                System.out.println("不认识了");
                break;
        }

    }
}

public class ZipCode{
    private String zipCode;

    ZipCode(String num){
        this.setZipCode(num);
    }

    public static void main(String[] args){
        ZipCode zip1=new ZipCode("11111");
        ZipCode zip2=new ZipCode("111111");
        System.out.println(zip1.getZipCode());
        System.out.println(zip2.getZipCode());
    }

    public void setZipCode(String num){
        if((num.length()==5)|(num.length()==9)){
            zipCode=num;
        }
    }

    public String getZipCode(){
        return this.zipCode;
    }
}
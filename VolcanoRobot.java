class VolcanoRobot{
    String status;
    int speed;
    float temperature;

    public void checkTemperature(){
        if(temperature>660){
            status="returning home";
            speed=5;
        }
    }

    public void showAttributes(){
        System.out.println("status:"+status);
        System.out.println("speed:"+speed);
        System.out.println("temperature:"+temperature);
    }
}
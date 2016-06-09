class ShowDays {
	public static void main(String[] args) {
		if (args.length==1) {
			int yearIn=Integer.parseInt(args[0]);
			int[] monthIn=new int[12];
			for (int i=0; i<=11; i++) {
				monthIn[i]=countDays((i+1),yearIn);
				System.out.println((i+1)+"month: "+monthIn[i]+" days.");
			}
		}
	}

	static int countDays(int month,int year){
		int count=-1;
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				count=31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				count=30;
				break;
			case 2:
				if (year%4==0) {
					count=29;
				}else{
					count=28;
				}
				if ((year%100==0)&(year%400!=0)) {
					count=28;
				}
				break;
		}
		return count;
	}
}
class ExchangeLonger {
	public static void main(String[] args) {
		if (args.length==1) {
			long num=changeLong(args[0]);
			System.out.println(num);
		}
	}

	public static long changeLong(String str){
		long num=0;
		switch (str) {
			case "one":
			num= (long)1;
			break;
			case "two":
			num= (long)2;
			break;
			case "three":
			num= (long)3;
			break;
			case "four":
			num= (long)4;
			break;
			case "five":
			num= (long)5;
			break;
			case "six":
			num= (long)6;
			break;
			case "seven":
			num= (long)7;
			break;
			case "eight":
			num= (long)8;
			break;
			case "nine":
			num= (long)9;
			break;
			case "ten":
			num= (long)10;
			break;
		}
		return num;
	}
}
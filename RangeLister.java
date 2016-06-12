class RangeLister {
	public static void main(String[] args) {
		int[] range;
		RangeLister lister=new RangeLister();
		range=lister.makeRange(4,13);
		System.out.print("The array: [ ");
		for (int i=0; i<range.length; i++) {
			System.out.print(range[i]+" ");
		}
		System.out.println("]");
	}

	public int[] makeRange(int lower,int upper){
		int[] range=new int[(upper-lower)+1];
		for (int i=0; i<range.length; i++) {
			range[i]=lower++;
		}
		return range;
	}
}
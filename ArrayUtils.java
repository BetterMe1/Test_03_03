//Java数组章节练习题
public class ArrayUtils{
    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
		//TODO
		int[] temp = new int[data.length];
		temp = java.util.Arrays.copyOf(data,temp.length);
		java.util.Arrays.sort(temp);
        return temp[temp.length-1];
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        int[] temp = new int[data.length];
		temp = java.util.Arrays.copyOf(data,temp.length);
		java.util.Arrays.sort(temp);
        return temp[0];
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        //TODO
		int sum = 0;
		for(int i =0; i<data.length; i++){
			sum += data[i];
		}
        return sum;
    }
    
    //4.数组拼接
    public static int[] arrayJoin(int[] a, int[] b){
		//TODO
		int[] res = new int[a.length+b.length];
		res = java.util.Arrays.copyOf(a,res.length);
		System.arraycopy(b,0,res,a.length,b.length);
        return res;
    }

    //5.数组截取
    //[start, end)
    public static int[] arraySub(int[] data, int start , int end){
        //TODO
		int[] res = new int[end-start];
		System.arraycopy(data,start,res,0,end-start);
        return res;
    }
    
    //6.数组打印  4,3,2,1
    public static void printArray(int[] data){
        //TODO
		for(int i=0; i<data.length; i++){
			System.out.print(data[i]+"  ");
			if(i!=data.length-1){
				System.out.print(",");
			}
		}
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        //TODO
		int i=0;
		int j=data.length-1;
		while(i<j){
			int temp=data[i];
			data[i]=data[j];
			data[j]=temp;
			i++;
			j--;
		}
		printArray(data);
    }
    
    public static void main(String[] args){
        //TODO 测试
        int[] testArray = new int[] {5,4,3,2,1};
        System.out.print("testArray数组:");
		printArray(testArray);
		System.out.println();
		System.out.println("最大值："+arrayMaxElement(testArray));	
		System.out.println("最小值："+arrayMinElement(testArray));
		System.out.println("总和："+arrayElementSum(testArray));
		int[]a = new int[] {6,7,8};
		System.out.print("a数组:");
		printArray(a);
		System.out.println();
		System.out.print("拼接数组testArray和数组a的结果：");
		printArray(arrayJoin(testArray, a));
		System.out.println();
		System.out.print("截取数组testArray索引在[1,3)之间的数：");
		printArray(arraySub(testArray, 1 , 3));
		System.out.println();
		System.out.print("数组testArray反转：");
		printReversal(testArray);
    }
}
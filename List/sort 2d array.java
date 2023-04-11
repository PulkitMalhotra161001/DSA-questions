public class Main {
    public static void main(String[] args) {
        int arr[][]={{1,7},{9,1},{6,3},{7,2},{1,2}};
        print(arr);
        Arrays.sort(arr,(o1,o2)->o1[1]-o2[1]);
        print(arr);
    }
    public static void print(int arr[][]){
        for(int i[]:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

int arr[][]={{a,1},{b,2},{c,3}};
        
//o1 => {a,1}   &   o2 => {b,2} 
Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);

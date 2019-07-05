-It is all about union finder
-Members are proportional to objects (size of members are equal to size of objects) and they all are connected.


public class Cheack_If_All_Connected{
//Initialize The union finder and Components
  private UnionFindUF uf; 
  private int numComponents;

  public Cheack_If_All_Connected(int N) {
    uf = new QuickFindUF(N);
    numComponents = N;
  }
//Add two friends and cheak if they are connected
//If they are connected make a union of them

  public void addFriendship(int p1, int p2) {
    if (!uf.connected(p1, p2)) {
      --numComponents;
    }
    uf.union(p1,p2);
  }
//If all are connected return 1 
  public boolean fullyConnected() {
    return this.numComponents == 1;
  }

//Following is a union finder algohrithm which as i found as from 'Algohrithms 4th edition' book
class WeightedQuickUnionUF {
	private int id[]; // id[i] = parents of node i
	private int sz[]; // sz[i] = size of node i
	private int count; // number of connected components

	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; ++i) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int count() {
		return count;
	}

	private int root(int p) {
		while (id[p] != p) {
			id[p] = id[id[p]]; // path compression
			p = id[p];
		}
		return p;
	}

  public static void main(String[] args) {


int n = StdIn.readInt();
        WeightedQuickUnion uf = new WeightedQuickUnion(n);
        String date, time;
        //timestamps are sorted ascending
        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            date = StdIn.readString();
            time = StdIn.readString();


            uf.union(p, q);

            StdOut.println("["+p+","+q+"]");

            if(uf.getComponents() == 1){
                StdOut.println("All friends were connected at: " + date + time);
                break;
            }


}
/*The performance will be M lg N because we are iterating M times (the amount of lines in the log file) 
and the union operations takes: lg n
*/

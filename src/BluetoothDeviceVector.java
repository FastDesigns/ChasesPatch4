import java.util.Vector;

public class BluetoothDeviceVector {
	public static Vector<String> getMacVector(){
//		ServicesSearch ss = new ServicesSearch();
		Vector<String> finalVector = new Vector<String>();
		for(int x=0;x<2;x++){
//			System.out.println("Starting device search");
			Vector<String> tempVector = ServicesSearch.getMacs();
//			System.out.println("Ending device search");
			for (int y = 0; y<tempVector.size();y++){
//				System.out.println("Vector search");
				if (!finalVector.contains(tempVector.elementAt(y))){
					finalVector.add(tempVector.elementAt(y));
				}
			}
//			System.out.println("Vector search complete, sleeping");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
		return finalVector;
	}
}
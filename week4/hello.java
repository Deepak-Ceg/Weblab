import java.rmi.*;
public interface hello extends Remote{
	public void printMsg() throws RemoteException;
}

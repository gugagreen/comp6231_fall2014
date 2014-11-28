import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class SequencerMain extends Thread implements Serializable
{
	Integer _sequenceNumber;
	DatagramSocket _sequencerSocket=null;
	//SequencerUDPHandlerThread []ThreadArray;
	public void run()
	{
		int i=0;
		byte recieveRequestArray[]=new byte[1000];
		//ThreadArray= new SequencerUDPHandlerThread[10];
		System.out.println("Running the Sequencer main Class");
		try
		{
			_sequencerSocket = new DatagramSocket(9988);
		} 
		catch (SocketException e1) {
			e1.printStackTrace();
		}
		while(true)
		{
			try
			{
				
				System.out.println("In the while loop of the sequencer main class");
			
			DatagramPacket request= new DatagramPacket(recieveRequestArray,recieveRequestArray.length);
			_sequencerSocket.receive(request);
			System.out.println("The Request recieved ");
			SequencerUDPHandlerThread newThread= new SequencerUDPHandlerThread(this, request);
			newThread.start();
			//ThreadArray[i]= new SequencerUDPHandlerThread(this,request);
			//Thread newThread= new Thread(ThreadArray[i]);
			//newThread.start();
			//ThreadArray[i].start();
			i++;
			System.out.println("The Request  forwarded to the Thread");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}


	
	public static void main(String args[])
	{
		SequencerMain _startingObject= new SequencerMain();
		_startingObject.start();
		
	}

}

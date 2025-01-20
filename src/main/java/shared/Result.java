package shared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Result extends UnicastRemoteObject {
  private int id;
  private int candidateId;
  private int totalVotes;

  public Result(int id) throws RemoteException {
    this.id = id;
    this.candidateId = 0;
    this.totalVotes = 0;
  }

  public int getCandidateId() throws RemoteException {
    return candidateId;
  }

  public int getTotalVotes() throws RemoteException {
    return totalVotes;
  }

  public int getId() throws RemoteException{
    return id;
  }

  public void setCandidateId(int candidateId) throws RemoteException {
    this.candidateId = candidateId;
  }

  public void setTotalVotes(int totalVotes) throws RemoteException {
    this.totalVotes = totalVotes;
  }

  public Result getResult() throws RemoteException {
    return this;
  }
}

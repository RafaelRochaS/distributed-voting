package shared;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Vote implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private int candidateId;
  private int voterId;
  private int resultId;

  public Vote(int id, int candidateId, int voterId) throws RemoteException {
    this.id = id;
    this.candidateId = candidateId;
    this.voterId = voterId;
    this.resultId = 0;
  }

  public void setResultId(int resultId) throws RemoteException {
    this.resultId = resultId;
  }

  public int getId() throws RemoteException {
    return id;
  }

  public int getCandidateId() throws RemoteException {
    return candidateId;
  }

  public int getVoterId() throws RemoteException {
    return voterId;
  }

  public int getResultId() throws RemoteException {
    return resultId;
  }
}

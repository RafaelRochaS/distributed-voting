package shared;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Result implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private int candidateId;
  private ArrayList<Vote> votes = new ArrayList<Vote>();

  public Result(int id) throws RemoteException {
    this.id = id;
    this.candidateId = 0;
  }

  public int getCandidateId() throws RemoteException {
    return candidateId;
  }

  public int getTotalVotes() throws RemoteException {
    return votes.size();
  }

  public int getId() throws RemoteException{
    return id;
  }

  public void setCandidateId(int candidateId) throws RemoteException {
    this.candidateId = candidateId;
  }

  public Result getResult() throws RemoteException {
    return this;
  }

  public void addVote(Vote vote) throws RemoteException {
    votes.add(vote);
  }

  public int getNextVoteId() throws RemoteException {
    return votes.size() + 1;
  }
}

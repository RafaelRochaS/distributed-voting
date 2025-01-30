package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VotingService extends Remote {
  Candidate registerCandidate(String name, String party, String platform) throws RemoteException;
  void registerVote(int candidateId , int voterId) throws RemoteException;
  Candidate getCandidate(int candidateId) throws RemoteException;
  ArrayList<Candidate> getCandidates() throws RemoteException;
  Result getResult(int resultId) throws RemoteException;
  Result getResult() throws RemoteException;
}
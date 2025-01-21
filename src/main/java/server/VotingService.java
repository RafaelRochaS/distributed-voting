package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import shared.Candidate;
import shared.Result;

public interface VotingService extends Remote {
  void registerCandidate(Candidate Candidate) throws RemoteException;
  void registerVote(int candidateId , int voterId) throws RemoteException;
  Candidate getCandidate(int candidateId) throws RemoteException;
  ArrayList<Candidate> getCandidates() throws RemoteException;
  Result getResult(int resultId) throws RemoteException;
  Result getResult() throws RemoteException;
}
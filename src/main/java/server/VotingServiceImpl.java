package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import shared.Candidate;
import shared.Result;
import shared.Vote;
import shared.VotingService;

public class VotingServiceImpl extends UnicastRemoteObject implements VotingService  {
  private ArrayList<Candidate> candidates;
  private ArrayList<Result> results;
  private int lastResultId = 0;

  public VotingServiceImpl() throws RemoteException {
    candidates = new ArrayList<Candidate>();
    results = new ArrayList<Result>();
    results.add(new Result(lastResultId));
  }

  @Override
  public Candidate registerCandidate(String name, String party, String platform) throws RemoteException {
    Candidate candidate = new Candidate(candidates.size(), name, party, platform);
    candidates.add(candidate);

    return candidate;
  }

  @Override
  public void registerVote(int candidateId, int voterId) throws RemoteException {
    int nextVoteId = results.get(lastResultId).getNextVoteId();
    Vote vote = new Vote(nextVoteId, voterId, candidateId);

    candidates.get(candidateId).addVote(voterId);

    results.get(lastResultId).setCandidateId(candidateId);
    results.get(lastResultId).addVote(vote);
  }

  @Override
  public Candidate getCandidate(int candidateId) throws RemoteException {
    return candidates.get(candidateId);
  }

  @Override
  public ArrayList<Candidate> getCandidates() throws RemoteException {
    return candidates;
  }

  @Override
  public Result getResult(int resultId) throws RemoteException {
    return results.get(resultId).getResult();
  }

  @Override
  public Result getResult() throws RemoteException {
    return results.get(lastResultId);
  }
}

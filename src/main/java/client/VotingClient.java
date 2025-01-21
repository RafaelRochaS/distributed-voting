package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.VotingService;
import shared.Candidate;
import shared.Result;

public class VotingClient {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      VotingService votingService = (VotingService) registry.lookup("VotingService");

      Candidate candidate = new Candidate(1, "Joe da quebrada", "Tretas Pesadas", "Quebrar tudo");
      votingService.registerCandidate(candidate);
      votingService.registerVote(1, 1);
      votingService.registerVote(1, 2);
      Result result = votingService.getResult();

      System.out.printf("Total votes: %d", result.getTotalVotes());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

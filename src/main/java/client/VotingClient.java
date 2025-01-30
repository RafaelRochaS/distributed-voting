package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import shared.Candidate;
import shared.Result;
import shared.VotingService;

public class VotingClient {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      VotingService votingService = (VotingService) registry.lookup("VotingService");

      Candidate candidate = votingService.registerCandidate("Joe da Quebrada", "Tretas Pesadas", "Quebrar tudo");
      System.out.printf("Registered candidate: %s\n", candidate.getName());

      votingService.registerVote(candidate.getId(), 1);
      votingService.registerVote(candidate.getId(), 2);
      Result result = votingService.getResult();

      System.out.printf("Total votes: %d\n", result.getTotalVotes());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

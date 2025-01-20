package shared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Candidate extends UnicastRemoteObject {
  private int id;
  private String name;
  private String party;
  private int votes;
  private String plataform;
  private ArrayList<Integer> voters;

  public Candidate(int id, String name, String party, String plataform) throws RemoteException {
    this.id = id;
    this.name = name;
    this.party = party;
    this.plataform = plataform;
    this.votes = 0;
    this.voters = new ArrayList<Integer>();
  }

  public int getId() throws RemoteException {
    return id;
  }

  public String getName() throws RemoteException {
    return name;
  }

  public String getParty() throws RemoteException {
    return party;
  }

  public int getVotes() throws RemoteException {
    return votes;
  }

  public String getPlataform() throws RemoteException {
    return plataform;
  }

  public void addVote(int voterId) throws RemoteException {
    votes++;
    voters.add(voterId);
  }
}

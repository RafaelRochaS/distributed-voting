package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class VotingServer {
    public static void main(String[] args) {
    try {
      Registry registry;
      try {
        registry = LocateRegistry.getRegistry(1099);
        registry.list(); // Check if the registry is already active
        System.out.println("Connected to existing registry.");
      } catch (Exception e) {
        registry = LocateRegistry.createRegistry(1099);
        System.out.println("No registry found. Created a new registry on port 1099.");
      }

      VotingService server = new VotingServiceImpl();
      
      registry.rebind("VotingServer", server);
      System.out.println("Calculator Service is running...");
    } catch (Exception e) {
      System.err.println("Calculator server failed:");
      e.printStackTrace();
    }
  }
}

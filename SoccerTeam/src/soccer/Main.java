package soccer;

/**
 * Console class SoccerTeamMain.
 * Is to run the soccer team project with model, controller and view.
 */
public class Main {

  /**
   * Main method is to execute the program.
   *
   * @param args the built-in param.
   */
  public static void main(String[] args) {
    SoccerTeamModel model = new SoccerTeamImpl();
    SoccerTeamView view = new SoccerTeamViewSwing("Soccer Team - For Coach Use");
    SoccerTeamController controller = new SoccerTeamControllerSwing(model, view);
    controller.startBuildSoccerTeam();
  }
}

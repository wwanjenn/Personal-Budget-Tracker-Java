class TrackerApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(()->{
            TrackerView view = new TrackerView();
            TrackerController controller = new TrackerController(view);
        });
    }
}
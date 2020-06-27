package bookManager;

import java.util.List;

import interfaces.IGUI;
import interfaces.INews;
import loader.PluginLoader;

public class BookManager {

	public static void main(String[] args) throws InterruptedException {
		List<INews> newsPlugins = PluginLoader.load(INews.class);
		
		for (INews message : newsPlugins) {
			System.out.print(message.getNews() + "\n");
		}
		List<IGUI> myGUI = PluginLoader.load(IGUI.class);
		myGUI.get(0).getFrame("Erste Headline").setVisible(true);
	}
}

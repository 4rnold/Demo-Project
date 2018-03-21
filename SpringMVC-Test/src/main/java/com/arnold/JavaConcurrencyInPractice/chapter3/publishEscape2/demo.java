package com.arnold.JavaConcurrencyInPractice.chapter3.publishEscape2;

public class demo {

	private class ClickEvent implements ThisEscape.Event{

	}

	private class MouseManager implements ThisEscape.EventSource {

		@Override
		public void registerListener(ThisEscape.EventListener e) {

		}
	}

	private class MouseListener implements ThisEscape.EventListener {

		@Override
		public void onEvent(ThisEscape.Event e) {
			if (e instanceof ClickEvent) {
				System.out.println("click click ..");
			}
		}
	}


}

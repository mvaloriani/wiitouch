/*
 * Copyright (C) 2008-2009, Uwe Schmidt
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions: 
 * 
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE. 
 * 
 * The Software uses a third-party library (WiiRemoteJ) which is not part of
 * the Software and is subject to its own license.
 */

package org.uweschmidt.wiimote.whiteboard;

import javax.swing.JOptionPane;

import org.uweschmidt.wiimote.whiteboard.preferences.WWPreferences;

import Personal.Evento;

import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;

public class WiimoteConnector {
	
	private WiimoteDataHandler dh;
	
	public WiimoteConnector(WiimoteDataHandler dh) {
		this.dh = dh;
	}
	
	public void connect() {
		if (!WWPreferences.WIIMOTE_BT_ADDRESSES.isEmpty()) {
			//OSCAR
			System.out.println("ok bluethot ");
			WiimoteWhiteboard.getLogger().info(String.format("Directly connecting to bluetooth address(es) %s.", WWPreferences.WIIMOTE_BT_ADDRESSES));
			for (int i = 0; i < Math.min(WWPreferences.WIIMOTE_BT_ADDRESSES.size(), WWPreferences.WIIMOTES); i++) {
				connect(WWPreferences.WIIMOTE_BT_ADDRESSES.get(i));
			}
		} else {
			//OSCAR
			try{
				WiiRemoteJ.findRemotes(dh, WWPreferences.WIIMOTES);
			}catch(IllegalStateException e){
				/*
				new Thread(new Runnable() {
					public void run() {
					
				
				System.out.println("non bluethoth input valuore " +valu);
				if(valu==0)
				{//Se vuole ritentare riprovo a riaprire 
					//dovrei chiudere!!
					try{
					Thread.sleep(1000);}
					catch(Exception e34){};
					//this.connect();
					Evento.getInterfaccia().connect();
					//WiimoteWhiteboard.main(null);
					
				
				}}
				}).start();
				*/
			}
		}
	}
	
	private void connect(final String address) {
		new Thread(new Runnable() {
			private boolean done = false;
			public void run() {
				while (!done) {
					try {
						WiiRemote r = WiiRemoteJ.connectToRemote(address);
						if (r != null && r.isConnected()) {
							done = true;
							dh.addRemote(r);
						}
					} catch (Exception e) {
//						if (e.getCause().getMessage().startsWith("Failed to open baseband connection")) {
//							// apparently simple timeout error
//						} else {
//							// "regular" connection error
//						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}						
					}
				}
			}
		}).start();
	}

}

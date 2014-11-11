package Controller;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;


public class ListenerDirectory{

	private WatchService watcher;
	private Kind<Path> ENTRY_CREATE = java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
	private Kind<Path> ENTRY_DELETE = java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
	private Kind<Path> ENTRY_MODIFY = java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
	private Kind<Object> OVERFLOW = java.nio.file.StandardWatchEventKinds.OVERFLOW;
	
	private FileController fileController;
	
	public ListenerDirectory() {
		fileController = new FileController();
	}
	
	public void startListener(String pathSrc, String pathDst)
	{
		try {
			watcher = FileSystems.getDefault().newWatchService();
			Path dir = Paths.get(pathSrc);
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    		while (true) {
    		    WatchKey key;
    		    try {
    		        // wait for a key to be available
    		        key = watcher.take();
    		    } catch (InterruptedException ex) {
    		        return;
    		    }
    		 
    		    for (WatchEvent<?> event : key.pollEvents()) {
    		        // get event type
    		        WatchEvent.Kind<?> kind = event.kind();
    		 
    		        // get file name
    		        @SuppressWarnings("unchecked")
    		        WatchEvent<Path> ev = (WatchEvent<Path>) event;
    		        Path fileName = ev.context();
    		 
    		 
    		        if (kind == OVERFLOW) {
    		            continue;
    		        } else if (kind == ENTRY_CREATE) {
    		 
    			        System.out.println(kind.name() + ": " + fileName);
    			        if(fileController.validateFile(fileName.toFile())){
    			        	
    			        	fileController.moveFile(fileName, dir, pathDst);
    			        	
    			        }
    		 
    		        } else if (kind == ENTRY_DELETE) {
    		 
    			        System.out.println(kind.name() + ": " + fileName);
    		 
    		        } else if (kind == ENTRY_MODIFY) {
    		 
    			        System.out.println(kind.name() + ": " + fileName);
    		 
    		        }
    		    }
    		 
    		    // IMPORTANT: The key must be reset after processed
    		    boolean valid = key.reset();
    		    if (!valid) {
    		        break;
    		    }
    		}
		} catch (IOException e) {
			System.out.println("Errore Server Interno");
		} catch (Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		

		
		
	}
	
}

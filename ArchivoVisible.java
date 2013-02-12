
import javax.swing.*;
import javax.swing.filechooser.*;

import java.io.File;
import java.util.Hashtable;

/**
 * author Jose Benjamin Perez Soto
 * version 0.0.0.0.0.14.14;
 */

public class ArchivoVisible extends FileView
{
	private Hashtable iconos = new Hashtable(5);
	private Hashtable archivoDescripcion = new Hashtable(5);
	private Hashtable tipoDescripcion = new Hashtable(5);

	public String getNobre(File f)
	{
		return null;
	}

	public void ponerDescripsion(File f, String fileDescription)
	{
		archivoDescripcion.put(archivoDescripcion, f);
	}
	
	public String getDescription(File f)
	{
		return (String) archivoDescripcion.get(f);
	};

	public void ponerTipoDescripcion(String extension, String tipoDescrip)
	{
		tipoDescripcion.put(tipoDescrip, extension);
	}

	public void putTypeDescription(File f, String typeDescription)
	{
		putTypeDescription(getExtension(f), typeDescription);
	}

    /**
     * A human readable description of the type of the file.
     *
     * @see FileView#getTypeDescription
     */
    public String getTypeDescription(File f) {
	return (String) typeDescriptions.get(getExtension(f));
    }

    /**
     * Conveinience method that returnsa the "dot" extension for the
     * given file.
     */
    public String getExtension(File f) {
	String name = f.getName();
	if(name != null) {
	    int extensionIndex = name.lastIndexOf('.');
	    if(extensionIndex < 0) {
		return null;
	    }
	    return name.substring(extensionIndex+1).toLowerCase();
	}
	return null;
    }

    /**
     * Adds an icon based on the file type "dot" extension
     * string, e.g: ".gif". Case is ignored.
     */
    public void putIcon(String extension, Icon icon) {
	icons.put(extension, icon);
    }

    /**
     * Icon that reperesents this file. Default implementation returns
     * null. You might want to override this to return something more
     * interesting.
     *
     * @see FileView#getIcon
     */
    public Icon getIcon(File f) {
	Icon icon = null;
	String extension = getExtension(f);
	if(extension != null) {
	    icon = (Icon) icons.get(extension);
	}
	return icon;
    }

    /**
     * Whether the file is hidden or not. This implementation returns
     * true if the filename starts with a "."
     *
     * @see FileView#isHidden
     */
    public Boolean isHidden(File f) {
	String name = f.getName();
	if(name != null && !name.equals("") && name.charAt(0) == '.') {
	    return Boolean.TRUE;
	} else {
	    return Boolean.FALSE;
	}
    };

    /**
     * Whether the directory is traversable or not. Generic implementation
     * returns true for all directories and special folders.
     *
     * You might want to subtype ExampleFileView to do somethimg more interesting,
     * such as recognize compound documents directories; in such a case you might
     * return a special icon for the diretory that makes it look like a regular
     * document, and return false for isTraversable to not allow users to
     * descend into the directory.
     *
     * @see FileView#isTraversable
     */
    public Boolean isTraversable(File f) {
	// if (some_reason) {
	//    return Boolean.FALSE;
	// }
	return null;	// Use default from FileSystemView
    };

}
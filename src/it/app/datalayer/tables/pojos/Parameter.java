/**
 * This class is generated by jOOQ
 */
package it.app.datalayer.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Parameter implements java.io.Serializable {

	private static final long serialVersionUID = 2006331852;

	private java.lang.Integer id;
	private java.lang.String  srcPath;
	private java.lang.String  dstPath;
	private java.lang.String  descrizione;

	public Parameter() {}

	public Parameter(
		java.lang.Integer id,
		java.lang.String  srcPath,
		java.lang.String  dstPath,
		java.lang.String  descrizione
	) {
		this.id = id;
		this.srcPath = srcPath;
		this.dstPath = dstPath;
		this.descrizione = descrizione;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getSrcPath() {
		return this.srcPath;
	}

	public void setSrcPath(java.lang.String srcPath) {
		this.srcPath = srcPath;
	}

	public java.lang.String getDstPath() {
		return this.dstPath;
	}

	public void setDstPath(java.lang.String dstPath) {
		this.dstPath = dstPath;
	}

	public java.lang.String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(java.lang.String descrizione) {
		this.descrizione = descrizione;
	}
}

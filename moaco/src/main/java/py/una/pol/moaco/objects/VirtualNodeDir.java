package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;

public class VirtualNodeDir implements Comparable<VirtualNodeDir>{

	private Integer id;
	private Integer cpu;
	private Integer LRC;
	private List<VirtualLinkDir> listaEnlaces;
	public VirtualNodeDir(Integer id, Integer cpu) {
		this.id = id;
		this.cpu = cpu;
		this.listaEnlaces = new ArrayList<VirtualLinkDir>();
	}
	public VirtualNodeDir() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpu() {
		return cpu;
	}
	public void setCpu(Integer cpu) {
		this.cpu = cpu;
	}
	public Integer getLRC() {
		return LRC;
	}
	public void setLRC(Integer lRC) {
		LRC = lRC;
	}
	public List<VirtualLinkDir> getListaEnlaces() {
		return listaEnlaces;
	}
	public void setListaEnlaces(List<VirtualLinkDir> listaEnlaces) {
		this.listaEnlaces = listaEnlaces;
	}
	public int compareTo(VirtualNodeDir virtual) {
		int cantidadComparada = ((VirtualNodeDir) virtual).getLRC();
		return this.getLRC() - cantidadComparada;
	}
	
	
	
	
}

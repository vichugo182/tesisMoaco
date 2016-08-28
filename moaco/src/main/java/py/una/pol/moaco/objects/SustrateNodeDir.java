package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jean Salcedo
 * Clase que abstrae un nodo fisico 
 * 
 */
public class SustrateNodeDir implements Comparable<SustrateNodeDir>{
	private Integer id;
	private Integer cpu;
	private Integer cpuDisponible;
	private Integer laLRC;
	private Integer LRC;
	private List<SustrateLinkDir> listaEnlaces;
	private boolean mapeado;
	
	public SustrateNodeDir() {
	}

	public SustrateNodeDir(Integer id, int cpu) {
		this.id = id;
		this.cpu = cpu;
		this.cpuDisponible = cpu;
		this.listaEnlaces = new ArrayList<SustrateLinkDir>();
	}
	
	public Integer getLaLRC() {
		return laLRC;
	}

	public void setLaLRC(Integer laLRC) {
		this.laLRC = laLRC;
	}

	public Integer getLRC() {
		return LRC;
	}

	public void setLRC(Integer lRC) {
		LRC = lRC;
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

	public Integer getCpuDisponible() {
		return cpuDisponible;
	}

	public void setCpuDisponible(Integer cpuDisponible) {
		this.cpuDisponible = cpuDisponible;
	}

	public List<SustrateLinkDir> getListaEnlaces() {
		return listaEnlaces;
	}

	public void setListaEnlaces(List<SustrateLinkDir> listaEnlaces) {
		this.listaEnlaces = listaEnlaces;
	}
	
	public void addLink (SustrateLinkDir enlace){
		this.listaEnlaces.add(enlace);
	}

	public boolean getMapeado() {
		return mapeado;
	}

	public void setMapeado(boolean mapeado) {
		this.mapeado = mapeado;
	}

	public int compareTo(SustrateNodeDir sustrate) {
		int cantidadComparada = ((SustrateNodeDir) sustrate).getLaLRC();
		return this.getLaLRC() - cantidadComparada;
	}
	

}

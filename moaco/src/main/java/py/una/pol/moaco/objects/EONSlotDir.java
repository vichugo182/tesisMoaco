package py.una.pol.moaco.objects;

/***
 * 
 * @author Jean
 * Clase que representa un slot de la red EON
 * 
 */
public class EONSlotDir {
	private Integer idSlot;
	private Number frecInicio;  ///representa la minima frecuencia con que inicia el slot
	private Number tamanho; 	///representa el tamanho de la frecuencia
	private boolean ocupado;
	
	public EONSlotDir() {
	}
	
	public Integer getIdSlot() {
		return idSlot;
	}
	public void setIdSlot(Integer idSlot) {
		this.idSlot = idSlot;
	}
	public Number getFrecInicio() {
		return frecInicio;
	}
	public void setFrecInicio(Number frecInicio) {
		this.frecInicio = frecInicio;
	}
	public Number getTamanho() {
		return tamanho;
	}
	public void setTamanho(Number tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
}

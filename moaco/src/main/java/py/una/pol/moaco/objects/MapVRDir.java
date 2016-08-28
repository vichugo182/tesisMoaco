package py.una.pol.moaco.objects;

public class MapVRDir {

	private Integer idFisico;
	private Integer idRequest;

	public MapVRDir(Integer idFisico, Integer idRequest) {
		this.idFisico = idFisico;
		this.idRequest = idRequest;
	}

	public Integer getIdFisico() {
		return idFisico;
	}

	public void setIdFisico(Integer idFisico) {
		this.idFisico = idFisico;
	}

	public Integer getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}
}

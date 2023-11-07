package model;

import java.util.Date;

public class Reserva {
	private int id;
	private Date data;
	private String status;
	private int ClienteId;
	private int FuncionarioId;
	private int DestinoId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getClienteId() {
		return ClienteId;
	}
	public void setClienteId(int clienteId) {
		ClienteId = clienteId;
	}
	public int getFuncionarioId() {
		return FuncionarioId;
	}
	public void setFuncionarioId(int funcionarioId) {
		FuncionarioId = funcionarioId;
	}
	public int getDestinoId() {
		return DestinoId;
	}
	public void setDestinoId(int destinoId) {
		DestinoId = destinoId;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", data=" + data + ", status=" + status + ", ClienteId=" + ClienteId
				+ ", FuncionarioId=" + FuncionarioId + ", DestinoId=" + DestinoId + "]";
	}
	
	
	
	
}

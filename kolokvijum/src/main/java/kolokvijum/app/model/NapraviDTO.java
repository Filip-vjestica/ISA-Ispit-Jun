package kolokvijum.app.model;

import kolokvijum.app.DTO.DTO;

public interface NapraviDTO<ID> {
	public DTO getDTO(boolean isInsideDTO);
	public ID getId();

}

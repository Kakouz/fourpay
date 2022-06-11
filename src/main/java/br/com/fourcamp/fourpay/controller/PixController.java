package br.com.fourcamp.fourpay.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.PixDTO;
import br.com.fourcamp.fourpay.model.Pix;
import br.com.fourcamp.fourpay.service.PixService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pix")
@Tag(name="API REST Pix")
@CrossOrigin(origins = "*")
public class PixController {

	@Autowired
	PixService pixService;
	
	@PostMapping
	@Operation(summary = "Cria um novo pix")
	public Pix createPix(@RequestBody PixDTO pixDto) {
		Pix pix = new Pix();
		BeanUtils.copyProperties(pixDto, pix);
		return pixService.save(pix);
	}
	
	@GetMapping
	@Operation(summary = "Retorna todos os pix cadastrados")
	public List<Pix> listAllPix() {
		return pixService.findAll();
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um pix")
	public Pix updatePix(@RequestBody PixDTO pixDto) {
		Pix pix = new Pix();
		BeanUtils.copyProperties(pixDto, pix);
		return pixService.updatePix(pix);
	}
	
	
}

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pix")
@Api(value="API REST Pix")
@CrossOrigin(origins = "*")
public class PixController {

	@Autowired
	PixService pixService;
	
	@PostMapping
	@ApiOperation(value = "Cria um novo pix")
	public Pix createPix(@RequestBody PixDTO pixDto) {
		Pix pix = new Pix();
		BeanUtils.copyProperties(pixDto, pix);
		return pixService.save(pix);
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os pix cadastrados")
	public List<Pix> listAllPix() {
		return pixService.findAll();
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza um pix")
	public Pix updatePix(@RequestBody PixDTO pixDto) {
		Pix pix = new Pix();
		BeanUtils.copyProperties(pixDto, pix);
		return pixService.updatePix(pix);
	}
	
	
}

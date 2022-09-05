package com.tokiomarine.transferencias.application.adapters.controllers;

import com.tokiomarine.transferencias.domain.transfer.dtos.TransferRequestBodyDTO;
import com.tokiomarine.transferencias.domain.transfer.dtos.TransferResponseBodyDTO;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferServicePort;
import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("transfer")
public class TransferController {

    private final TransferServicePort transferServicePort;

    public TransferController(TransferServicePort transferServicePort) {
        this.transferServicePort = transferServicePort;
    }

    private URI getURI(UUID id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    @GetMapping
    public ResponseEntity<Page<TransferResponseBodyDTO>> getAllTransfersPaged(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok().body(transferServicePort.findTransfers(pageable));
    }

    @PostMapping
    public ResponseEntity scheduleTransfer(@RequestBody TransferRequestBodyDTO body) {
        TransferEntity savedEntity = transferServicePort.saveTransfer(body);
        return ResponseEntity.created(getURI(savedEntity.getTransferId())).build();
    }
}

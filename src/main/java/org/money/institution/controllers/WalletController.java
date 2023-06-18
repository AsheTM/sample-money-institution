package org.money.institution.controllers;

import org.money.institution.exceptions.InsufficientBalanceException;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.exceptions.NotFoundException;
import org.money.institution.views.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/api")
public interface WalletController {

	@RequestMapping("/client")
	interface ClientController {

		@GetMapping("/")
		ClientsResponseView showClients();
		
		@GetMapping("/{idC}")
		ClientResponseView showClient(@PathVariable("idC") int idClient) throws NotFoundException;
		
		@PostMapping("/")
		ClientResponseView addClient(@RequestBody ClientRequestView clientRequestView);
		
	}

	@RequestMapping("/client/{idC}/account")
	interface AccountController {

		@GetMapping("/")
		AccountsResponseView showAccounts(@PathVariable("idC") int idClient) throws ClientNotFoundException;

		@GetMapping("/{idA}")
		AccountResponseView showAccount(@PathVariable("idC") int idClient, @PathVariable("idA") int idAccount)
				throws NotFoundException;
		
		@PostMapping("/")
		AccountResponseView addAccount(@PathVariable("idC") int idClient) throws ClientNotFoundException;

		@PostMapping("/{idA}/withdraw")
		AccountResponseView withdraw(@PathVariable("idC") int idClient, @PathVariable("idA") int idAccount,
									 @RequestBody TransactionRequestView transactionRequestView)
				throws InsufficientBalanceException, NotFoundException;

		@PostMapping("/{idA}/deposit")
		AccountResponseView deposit(@PathVariable("idC") int idClient, @PathVariable("idA") int idAccount,
									@RequestBody TransactionRequestView transactionRequestView)
				throws NotFoundException;
		
		@PatchMapping("/{idA}")
		AccountResponseView activateAccount(@PathVariable("idC") int idClient, @PathVariable("idA") int idAccount)
				throws NotFoundException;
		
		@DeleteMapping("/{idA}")
		AccountResponseView deactivateAccount(@PathVariable("idC") int idClient, @PathVariable("idA") int idAccount)
				throws NotFoundException;
		
	}

	@RequestMapping("/client/{idC}/account/{idA}/transaction")
	interface TransactionController {

		@GetMapping("/")
		TransactionsResponseView showTransactions(@PathVariable("idC") int idClient, @PathVariable("idA") int idAccount)
				throws NotFoundException;

		@GetMapping("/{idT}")
		TransactionResponseView showTransaction(@PathVariable("idC") int idClient, @PathVariable("idA") int idAccount,
												@PathVariable("idT") int idTransaction) throws NotFoundException;
		
	}

}

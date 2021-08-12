package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.exceptions.AccountNotFoundException;
import com.cg.paymentapp.repositories.AccountRepository;
import com.cg.paymentapp.services.BankAccountServiceImpl;

@ExtendWith(SpringExtension.class)
public class TestBankAccoutservice {
	
@InjectMocks
private BankAccountServiceImpl bankSeviceImpl;

@Mock
private AccountRepository accountRepo;

@BeforeEach
void intit() {
	MockitoAnnotations.openMocks(this);
}
	
	
@Test
public void testAddAccount() {
	
	BankAccount bankAccount= new BankAccount();
    BankAccount updatedbankAccount= new BankAccount();
    updatedbankAccount.setAccountNo(1);
	
    Mockito.when(accountRepo.save(bankAccount)).thenReturn(updatedbankAccount);
     
    assertEquals(1,bankSeviceImpl.addAccount(bankAccount).getAccountNo());
 
}

@Test
public void test() {
	
	BankAccount bankAccount= new BankAccount();
    bankAccount.setAccountNo(1);
	
     Mockito.when(accountRepo.findById(1)).thenReturn(Optional.of(bankAccount));
	 assertEquals(1,bankSeviceImpl.removeBankAccount(1).getAccountNo());
	
}


@Test
public void testViewAccount() {
	BankAccount bankAccount= new BankAccount();
    bankAccount.setAccountNo(1);
	
	
     Mockito.when(accountRepo.findById(1)).thenReturn(Optional.of(bankAccount));
	 assertEquals(1,bankSeviceImpl.viewAccount(1).getAccountNo());
	
}

@Test
public void testViewAccountInvalid() {
	
	BankAccount bankAccount= new BankAccount();
    bankAccount.setAccountNo(1);
    
    Mockito.when(accountRepo.findById(1)).thenReturn(Optional.of(bankAccount));
    assertThrows(AccountNotFoundException.class,()->{bankSeviceImpl.viewAccount(2);
    	
    }
    );
	
}
@Test
public void testViewAllAccounts() {
	
	
	 Mockito.when(accountRepo.findAll()).thenReturn(Arrays.asList(new BankAccount()));;
	 assertEquals(1,bankSeviceImpl.viewAllBankAccounts().size());
	
}



}

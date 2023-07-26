describe('e2e test', () => {
  it('passes', () => {
    cy.visit('/')
    cy.contains('here').click()
    cy.get('body').contains('Hello Gamers')
    cy.get('#command').type('help{enter}')
  })
})


describe('e2e test with mocked server response', () => {
  it('passes', () => {

    cy.intercept('GET', '/command*', 'some txt').as('getCommand')

    cy.visit('/game')
    cy.get('#command').type('help{enter}')
    cy.wait('@getCommand')
    cy.get('body').contains('some txt')
  })
})
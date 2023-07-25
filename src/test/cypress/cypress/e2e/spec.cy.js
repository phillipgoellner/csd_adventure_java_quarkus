describe('template spec', () => {
  it('passes', () => {
    cy.visit('/')
    cy.contains('here').click()
    cy.get('body').contains('Hello Gamers')
    cy.get('#command').type('help{enter}')
  })
})
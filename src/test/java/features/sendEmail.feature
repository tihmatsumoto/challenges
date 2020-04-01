Feature: Send email to server

  Scenario: User sending email to server
    Given A User sends an "hello" message
    When The message is converted by the Adapter
    Then The Message server should contain the "hello" message in the queue

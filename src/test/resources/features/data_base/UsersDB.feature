@db
  #In my project, we never ever do db validation without UI validation
  # Usually, in every scenario we add,edit,delete something on the UI
  # Verify that action on the UI was successful
  #  And then we also verify same thing in the DB
#  For example: add user with some information
#  verify that user exists on UI
#  and verify that user exists with same information in DB
#  or Book the ROOM, verify it booked on the UI
#  and verify that reservation is also appears in the DB
Feature: Users table in data base

    Scenario: Verify users email
      Given user verifies that user with id 1746 has email "admin@mail.com"
-- Create the credit_history table
CREATE TABLE credit_history (
    ssn VARCHAR(20) NOT NULL PRIMARY KEY,
    credit_score INT NOT NULL,
    debt_income DECIMAL(10, 2) NOT NULL,
    missed_payment_history INT NOT NULL,
credit_utilization DECIMAL(10, 2) NOT NULL,
credit_history_length INT NOT NULL,
recent_credit_inquiries INT NOT NULL,
existing_credit_products INT NOT NULL
);

-- Insert sample data
INSERT INTO credit_history (ssn, credit_score, debt_income, missed_payment_history,credit_utilization, credit_history_length, recent_credit_inquiries, existing_credit_products) VALUES
    ('123456001', 648, 0.49, 3, 0.74, 13, 4, 5);


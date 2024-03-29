/*
 * Copyright (c) 2012 University of Nice Sophia-Antipolis
 *
 * This file is part of btrplace.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package btrplace.model.constraint;

import btrplace.JSONConverterException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Unit tests for {@link btrplace.model.constraint.SequentialVMTransitions}.
 *
 * @author Fabien Hermenier
 */
public class SequentialVMTransitionsConverterTest implements ConstraintTestMaterial {

    private static SequentialVMTransitionsConverter conv = new SequentialVMTransitionsConverter();

    @Test
    public void testViables() throws JSONConverterException {
        SequentialVMTransitions d = new SequentialVMTransitions(Arrays.asList(vm1, vm2, vm3));
        SequentialVMTransitions c = new SequentialVMTransitions(Arrays.asList(vm1, vm2, vm3));
        Assert.assertEquals(conv.fromJSON(conv.toJSON(d)), d);
        Assert.assertEquals(conv.fromJSON(conv.toJSON(c)), c);
    }
}

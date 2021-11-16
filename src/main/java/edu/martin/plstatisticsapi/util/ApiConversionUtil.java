package edu.martin.plstatisticsapi.util;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import edu.martin.plstatisticsapi.model.Privilege;
import edu.martin.plstatisticsapi.model.Role;

import java.util.Collection;
import java.util.Set;

public final class ApiConversionUtil {

  private ApiConversionUtil() {
    throw new AssertionError();
  }

  // API

  public static Set<Privilege> convertRolesToPrivileges(final Iterable<Role> roles) {
    final Set<Privilege> privileges = Sets.<Privilege> newHashSet();
    for (final Role roleOfUser : roles) {
      privileges.addAll(roleOfUser.getPrivileges());
    }
    return privileges;
  }

  public static Collection<String> convertPrivilegesToPrivilegeNames(final Collection<Privilege> privileges) {
    final Function<Object, String> toStringFunction = Functions.toStringFunction();
    return Collections2.transform(privileges, toStringFunction);
  }

  public static Collection<String> convertRolesToPrivilegeNames(final Iterable<Role> roles) {
    final Set<Privilege> privileges = convertRolesToPrivileges(roles);
    return convertPrivilegesToPrivilegeNames(privileges);
  }

}

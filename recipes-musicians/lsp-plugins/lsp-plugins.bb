require ${BPN}.inc

inherit distro_features_check pack_audio_plugins

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    ${BPN}-native \
    php-native \
    cairo \
    gtk+ \
    gtk+3 \
    jack \
    libsndfile1 \
    ladspa-sdk \
    lv2 \
"

SRC_URI += " \
    file://0001-Makefile-align-for-oe-cross-build.patch \
    file://0002-Pass-LDFLAGS-to-so-lib-builds.patch \
"

ARM_INSTRUCTION_SET = "arm"

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE_armv7a = "(.*)"
COMPATIBLE_MACHINE_armv7ve = "(.*)"
COMPATIBLE_MACHINE_aarch64 = "(.*)"
COMPATIBLE_MACHINE_x86 = "(.*)"
COMPATIBLE_MACHINE_x86-64 = "(.*)"

LSP_TARGET_ARCH = ""
LSP_TARGET_ARCH_armv7a = "armv7a"
LSP_TARGET_ARCH_armv7ve = "armv7a"
LSP_TARGET_ARCH_aarch64 = "aarch64"
LSP_TARGET_ARCH_x86 = "i586"
LSP_TARGET_ARCH_x86-64 = "x86_64"

EXTRA_OEMAKE += " \
    BUILD_PLATFORM=Linux \
    BUILD_PROFILE=${LSP_TARGET_ARCH} \
    PREFIX=${prefix} \
"

do_compile_prepend() {
    export CC_ARCH="${CXXFLAGS}"
    export LD_ARCH="`echo $LDFLAGS | sed 's:-Wl,::g'`"
}

do_install() {
    ${MAKE} ${EXTRA_OEMAKE} DESTDIR=${D} install
}

FILES_${PN} += "${libdir}/lsp-plugins-jack-core-${PV}.so"

PACKAGES =+ "${PN}-standalone"
FILES_${PN}-standalone = "${bindir}"
